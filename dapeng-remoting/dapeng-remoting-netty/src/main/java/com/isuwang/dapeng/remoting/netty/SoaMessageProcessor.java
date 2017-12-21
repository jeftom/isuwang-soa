package com.isuwang.dapeng.remoting.netty;


import com.isuwang.dapeng.core.*;
import com.isuwang.dapeng.core.enums.CodecProtocol;
import com.isuwang.org.apache.thrift.TException;
import com.isuwang.org.apache.thrift.protocol.TBinaryProtocol;
import com.isuwang.org.apache.thrift.protocol.TCompactProtocol;
import com.isuwang.org.apache.thrift.protocol.TJSONProtocol;
import com.isuwang.org.apache.thrift.protocol.TProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lihuimin on 2017/12/8.
 */
public class SoaMessageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoaMessageProcessor.class);

    private final byte STX = 0x02;
    private final byte ETX = 0x03;
    private final byte VERSION = 1;

    private TProtocol headerProtocol;
    private TProtocol contentProtocol;

    private final boolean isRequestFlag;

    public TSoaTransport transport;

    public TProtocol getHeaderProtocol() {
        return headerProtocol;
    }

    public void setHeaderProtocol(TProtocol headerProtocol) {
        this.headerProtocol = headerProtocol;
    }

    public TProtocol getContentProtocol() {
        return contentProtocol;
    }

    public void setContentProtocol(TProtocol contentProtocol) {
        this.contentProtocol = contentProtocol;
    }

    public TSoaTransport getTransport() {
        return transport;
    }

    public void setTransport(TSoaTransport transport) {
        this.transport = transport;
    }

    public SoaMessageProcessor(boolean isRequestFlag, TSoaTransport transport) {
        this.isRequestFlag = isRequestFlag;
        this.transport = transport;
    }


    public void writeHeader(TransactionContext context) throws TException {

        headerProtocol = new TBinaryProtocol(transport);

        headerProtocol.writeByte(STX);
        headerProtocol.writeByte(VERSION);
        headerProtocol.writeByte(context.getCodecProtocol().getCode());
        headerProtocol.writeI32(context.getSeqid());

        switch (context.getCodecProtocol()) {
            case Binary:
                contentProtocol = new TBinaryProtocol(transport);
                break;
            case CompressedBinary:
                contentProtocol = new TCompactProtocol(transport);
                break;
            case Json:
                contentProtocol = new TJSONProtocol(transport);
                break;
            case Xml:
                contentProtocol = null;
                break;
        }

        new SoaHeaderSerializer().write(context.getHeader(), headerProtocol);

        //contentProtocol.writeMessageBegin(message);
    }

    public SoaHeader parseSoaMessage() throws TException{
        final TransactionContext context = TransactionContext.Factory.getCurrentInstance();

        if (headerProtocol == null) {
            headerProtocol = new TBinaryProtocol(getTransport());
        }

        // length(int32) stx(int8) version(string) protocol(int8) header(struct) body(struct) etx(int8)

        byte stx = headerProtocol.readByte();
        if (stx != STX) {// 通讯协议不正确
            throw new TException("通讯协议不正确(起始符)");
        }

        // version
        byte version = headerProtocol.readByte();
        if (version!=VERSION) {
            throw new TException("通讯协议不正确(协议版本号)");
        }

        byte protocol = headerProtocol.readByte();
        context.setCodecProtocol(CodecProtocol.toCodecProtocol(protocol));
        switch (context.getCodecProtocol()) {
            case Binary:
                contentProtocol = new TBinaryProtocol(getTransport());
                break;
            case CompressedBinary:
                contentProtocol = new TCompactProtocol(getTransport());
                break;
            case Json:
                contentProtocol = new TJSONProtocol(getTransport());
                break;
            case Xml:
                //realContentProtocol = null;
                throw new TException("通讯协议不正确(包体协议)");
            default:
                throw new TException("通讯协议不正确(包体协议)");
        }

        context.setSeqid(headerProtocol.readI32());
        SoaHeader soaHeader =new SoaHeaderSerializer().read( headerProtocol);
        context.setHeader(soaHeader);
        return soaHeader;
    }

    public void writeMessageEnd() throws TException {
        contentProtocol.writeMessageEnd();

        headerProtocol.writeByte(ETX);
    }
}

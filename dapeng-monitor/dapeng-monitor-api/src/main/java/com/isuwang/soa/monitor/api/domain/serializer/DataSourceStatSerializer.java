 package com.isuwang.soa.monitor.api.domain.serializer;

 import com.isuwang.dapeng.core.*;
        import com.isuwang.org.apache.thrift.*;
        import com.isuwang.org.apache.thrift.protocol.*;

        import java.util.Optional;

 /**
        * Autogenerated by Dapeng-Code-Generator (1.2.2)
        *
        * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        *  @generated
        **/
        public class DataSourceStatSerializer implements BeanSerializer<com.isuwang.soa.monitor.api.domain.DataSourceStat>{
        
      @Override
      public com.isuwang.soa.monitor.api.domain.DataSourceStat read(TProtocol iprot) throws TException{

      com.isuwang.soa.monitor.api.domain.DataSourceStat bean = new com.isuwang.soa.monitor.api.domain.DataSourceStat();
      TField schemeField;
      iprot.readStructBegin();

      while(true){
        schemeField = iprot.readFieldBegin();
        if(schemeField.type == TType.STOP){ break;}

        switch(schemeField.id){
          
              case 1:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setPeriod(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 2:
              if(schemeField.type == TType.I64){
              long elem0 = iprot.readI64();
       bean.setAnalysisTime(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 3:
              if(schemeField.type == TType.STRING){
              String elem0 = iprot.readString();
       bean.setServerIP(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 4:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setServerPort(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 5:
              if(schemeField.type == TType.STRING){
              String elem0 = iprot.readString();
       bean.setUrl(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 6:
              if(schemeField.type == TType.STRING){
              String elem0 = iprot.readString();
       bean.setUserName(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 7:
              if(schemeField.type == TType.STRING){
              String elem0 = iprot.readString();
       bean.setIdentity(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 8:
              if(schemeField.type == TType.STRING){
              String elem0 = iprot.readString();
       bean.setDbType(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 9:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setPoolingCount(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 10:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setPoolingPeak(Optional.of(elem0));
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 11:
              if(schemeField.type == TType.I64){
              long elem0 = iprot.readI64();
       bean.setPoolingPeakTime(Optional.of(elem0));
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 13:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setActiveCount(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 14:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setActivePeak(Optional.of(elem0));
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 15:
              if(schemeField.type == TType.I64){
              long elem0 = iprot.readI64();
       bean.setActivePeakTime(Optional.of(elem0));
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 16:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setExecuteCount(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
              case 17:
              if(schemeField.type == TType.I32){
               int elem0 = iprot.readI32();
       bean.setErrorCount(elem0);
            }else{
              TProtocolUtil.skip(iprot, schemeField.type);
            }
              break;
            
          
            default:
            TProtocolUtil.skip(iprot, schemeField.type);
          
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      validate(bean);
      return bean;
    }
    
      @Override
      public void write(com.isuwang.soa.monitor.api.domain.DataSourceStat bean, TProtocol oprot) throws TException{

      validate(bean);
      oprot.writeStructBegin(new TStruct("DataSourceStat"));

      
            oprot.writeFieldBegin(new TField("period", TType.I32, (short) 1));
            Integer elem0 = bean.getPeriod();
            oprot.writeI32(elem0);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("analysisTime", TType.I64, (short) 2));
            Long elem1 = bean.getAnalysisTime();
            oprot.writeI64(elem1);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("serverIP", TType.STRING, (short) 3));
            String elem2 = bean.getServerIP();
            oprot.writeString(elem2);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("serverPort", TType.I32, (short) 4));
            Integer elem3 = bean.getServerPort();
            oprot.writeI32(elem3);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("url", TType.STRING, (short) 5));
            String elem4 = bean.getUrl();
            oprot.writeString(elem4);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("userName", TType.STRING, (short) 6));
            String elem5 = bean.getUserName();
            oprot.writeString(elem5);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("identity", TType.STRING, (short) 7));
            String elem6 = bean.getIdentity();
            oprot.writeString(elem6);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("dbType", TType.STRING, (short) 8));
            String elem7 = bean.getDbType();
            oprot.writeString(elem7);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("poolingCount", TType.I32, (short) 9));
            Integer elem8 = bean.getPoolingCount();
            oprot.writeI32(elem8);
            
            oprot.writeFieldEnd();
          if(bean.getPoolingPeak().isPresent()){
              oprot.writeFieldBegin(new TField("poolingPeak", TType.I32, (short) 10));
              Integer elem9 = bean.getPoolingPeak().get();
              oprot.writeI32(elem9);
              
            }
            if(bean.getPoolingPeakTime().isPresent()){
              oprot.writeFieldBegin(new TField("poolingPeakTime", TType.I64, (short) 11));
              Long elem10 = bean.getPoolingPeakTime().get();
              oprot.writeI64(elem10);
              
            }
            
            oprot.writeFieldBegin(new TField("activeCount", TType.I32, (short) 13));
            Integer elem11 = bean.getActiveCount();
            oprot.writeI32(elem11);
            
            oprot.writeFieldEnd();
          if(bean.getActivePeak().isPresent()){
              oprot.writeFieldBegin(new TField("activePeak", TType.I32, (short) 14));
              Integer elem12 = bean.getActivePeak().get();
              oprot.writeI32(elem12);
              
            }
            if(bean.getActivePeakTime().isPresent()){
              oprot.writeFieldBegin(new TField("activePeakTime", TType.I64, (short) 15));
              Long elem13 = bean.getActivePeakTime().get();
              oprot.writeI64(elem13);
              
            }
            
            oprot.writeFieldBegin(new TField("executeCount", TType.I32, (short) 16));
            Integer elem14 = bean.getExecuteCount();
            oprot.writeI32(elem14);
            
            oprot.writeFieldEnd();
          
            oprot.writeFieldBegin(new TField("errorCount", TType.I32, (short) 17));
            Integer elem15 = bean.getErrorCount();
            oprot.writeI32(elem15);
            
            oprot.writeFieldEnd();
          
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }
    
      public void validate(com.isuwang.soa.monitor.api.domain.DataSourceStat bean) throws TException{
      
              if(bean.getServerIP() == null)
              throw new SoaException(SoaCode.NotNull, "serverIP字段不允许为空");
            
              if(bean.getUrl() == null)
              throw new SoaException(SoaCode.NotNull, "url字段不允许为空");
            
              if(bean.getUserName() == null)
              throw new SoaException(SoaCode.NotNull, "userName字段不允许为空");
            
              if(bean.getIdentity() == null)
              throw new SoaException(SoaCode.NotNull, "identity字段不允许为空");
            
              if(bean.getDbType() == null)
              throw new SoaException(SoaCode.NotNull, "dbType字段不允许为空");
            
    }
    
        @Override
        public String toString(com.isuwang.soa.monitor.api.domain.DataSourceStat bean)
        {return bean == null ? "null" : bean.toString();}
      }
      

      
 package com.isuwang.soa.price.scala.domain.serializer;

        import com.isuwang.soa.user.scala.domain.serializer._;import com.isuwang.soa.price.scala.domain.serializer._;import com.isuwang.soa.order.scala.domain.serializer._;import com.isuwang.soa.settle.scala.domain.serializer._;
        import com.isuwang.dapeng.core._
        import com.isuwang.org.apache.thrift._
        import com.isuwang.org.apache.thrift.protocol._

        /**
        * Autogenerated by Dapeng-Code-Generator (1.2.2)
        *
        * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        *  @generated
        **/

        class PriceSerializer extends BeanSerializer[com.isuwang.soa.price.scala.domain.Price]{
          
      @throws[TException]
      override def read(iprot: TProtocol): com.isuwang.soa.price.scala.domain.Price = {

        var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null
        iprot.readStructBegin()

      var orderId: Int = 0
        var price: Double = 0.00
        

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {

        schemeField = iprot.readFieldBegin

        schemeField.id match {
          
              case 1 =>
                  schemeField.`type` match {
                    case com.isuwang.org.apache.thrift.protocol.TType.I32 => orderId = iprot.readI32
                    case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.`type`)
            }
            
              case 2 =>
                  schemeField.`type` match {
                    case com.isuwang.org.apache.thrift.protocol.TType.DOUBLE => price = iprot.readDouble
                    case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.`type`)
            }
            
          case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.`type`)
        }
      }

      iprot.readFieldEnd
      iprot.readStructEnd

      val bean = com.isuwang.soa.price.scala.domain.Price(orderId = orderId,price = price)
      validate(bean)

      bean
      }
    
      @throws[TException]
      override def write(bean: com.isuwang.soa.price.scala.domain.Price, oprot: TProtocol): Unit = {

      validate(bean)
      oprot.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("Price"))

      
            {
            val elem0 = bean.orderId 
            oprot.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("orderId", com.isuwang.org.apache.thrift.protocol.TType.I32, 1.asInstanceOf[Short]))
            oprot.writeI32(elem0)
            oprot.writeFieldEnd
            
            }
            {
            val elem1 = bean.price 
            oprot.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("price", com.isuwang.org.apache.thrift.protocol.TType.DOUBLE, 2.asInstanceOf[Short]))
            oprot.writeDouble(elem1)
            oprot.writeFieldEnd
            
            }
      oprot.writeFieldStop
      oprot.writeStructEnd
    }
    
      @throws[TException]
      override def validate(bean: com.isuwang.soa.price.scala.domain.Price): Unit = {
      
    }
    

          @throws[TException]
          override def toString(bean: com.isuwang.soa.price.scala.domain.Price): String = if (bean == null) "null" else bean.toString

        }
        
      

        package com.isuwang.soa.scala.service

import com.isuwang.dapeng.core.{Processor, Service}
        import com.isuwang.dapeng.core.SoaGlobalTransactional
        import scala.concurrent.Future

        /**
         * Autogenerated by Dapeng-Code-Generator (1.2.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated

        * 
        **/
        @Service(name ="com.isuwang.soa.service.SchedualService" , version = "1.0.0")
        @Processor(className = "com.isuwang.soa.scala.SchedualServiceAsyncCodec$Processor")
        trait SchedualServiceAsync {
        
            /**
            * 
            **/
            
            @throws[com.isuwang.dapeng.core.SoaException]
            def test(
             timeout : Long): Future[String]

          
      }
      
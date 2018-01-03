package com.isuwang.soa.scala

import com.isuwang.dapeng.core._;
        import com.isuwang.org.apache.thrift._;
        import java.util.ServiceLoader;
        import java.util.concurrent.CompletableFuture;
        import com.isuwang.soa.scala.SchedualServiceAsyncCodec._;
        import com.isuwang.soa.scala.service.SchedualServiceAsync;

        /**
         * Autogenerated by Dapeng-Code-Generator (1.2.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated

        **/
        class SchedualServiceAsyncClient extends SchedualServiceAsync {

        import java.util.function.{ Function ⇒ JFunction, Predicate ⇒ JPredicate, BiPredicate }
        implicit def toJavaFunction[A, B](f: Function1[A, B]) = new JFunction[A, B] {
          override def apply(a: A): B = f(a)
        }

        val serviceName = "com.isuwang.soa.scala.service.SchedualService"
        val version = "1.0.0"
        val pool = {
          val serviceLoader = ServiceLoader.load(classOf[SoaConnectionPoolFactory])
          if (serviceLoader.iterator().hasNext) {
            val poolImpl = serviceLoader.iterator().next().getPool
            poolImpl.registerClientInfo(serviceName,version)
            poolImpl
          } else null
        }

        def getServiceMetadata: String = {
          pool.send(
          serviceName,
          version,
          "getServiceMetadata",
          new getServiceMetadata_args,
          new GetServiceMetadata_argsSerializer,
          new GetServiceMetadata_resultSerializer
          ).success
        }


        

            /**
            * 
            **/
            def test(
             timeout: Long = 5000) : String = {

            val response = pool.sendAsync(
            serviceName,
            version,
            "test",
            test_args(),
            new Test_argsSerializer(),
            new Test_resultSerializer()
            ,timeout).asInstanceOf[CompletableFuture[test_result]]

            response.thenApply(_.success).get

          }

          
      }
      
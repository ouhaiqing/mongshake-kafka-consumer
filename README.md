# mongshake-kafka-consumer
由于对golang语言不够熟练, 再加上业务的需要, 需要实现kafk消费并对接到具体的场景， 此部分功能 仅仅是 实现kafka消费，并做了消费记录切分， 建议分片平衡的状态过滤。

注意事项： 
1.分片集群下的记录fromMigrate=true的过滤 
2.mongoshake那边消息发送可能要设置单条消息最大字节数。 
3.mongoshake组装批量记录的时候可以考虑 末尾拼接分隔符， 然后消费这边在切割，不然只会消费到第一条记录。

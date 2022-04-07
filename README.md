# 瀚云开放平台 OpenAPI JavaSDK
 
 **当前并未加入 Maven中央仓库，请使用Maven本地Package打包并安装使用**
 
 如果未了解瀚云平台鉴权体系，请先查看[文档](https://www.hanclouds.com/doc/2-authentication/index).
 
## Demo1案例
 
```java
HanCloudsClient hanCloudsClient = new HanCloudsClient("http://api.hanclouds.com/api/v1");
//Client增加失败重连机制，默认不开启
hanCloudsClient.setReTryCount(xxx);//重连次数（可选）
hanCloudsClient.setReTryTime(xxx);//重连间隔时间毫秒级（可选）
        
hanCloudsClient.putDeviceAuthParams("xxx", "xxx");

//准备获取设备某数据流最新数据
DeviceDataStreamLatestDataRequest dataReq = new DeviceDataStreamLatestDataRequest();
dataReq.setDeviceKey("xxx");
dataReq.setDataName("dataStreamName");

DeviceDataStreamLatestDataResponse response = hanCloudsClient.execute(dataReq);

if (response != null) {
    List<DeviceDataDTO> deviceDataDTOList = response.getResponse();
    //获取返回信息，并进行业务处理   
}
```
以上代码为获取某设备下，`dataStreamName` 数据流最新数据。
## Demo2案例
```java
  ApiCardClient client = new ApiCardClient("http://api.hanclouds.com/api/v1");
  client.putUserAuthParams(userKey, secretKey);
  client.setReTryCount(xxx);//重连次数（可选）
  client.setReTryTime(xxx);//重连间隔时间毫秒级（可选）
  CardStorePageRequest request = new CardStorePageRequest();//构建查询request
  Optional.ofNullable(msisdn).ifPresent(item->request.setMsisdns(item));//参数处理
  request.setPage(page);//分页码
  request.setPageSize(pageSize);//每页数
  return client.execute(request);
```
以上代码为获取物联卡仓库数据 分页效果。

在SDK中，瀚云平台每一个API都被封装成 `XXXRequest` 对象，被 `HanCloudsClient` 执行后，将返回对应的Response，方便使用，不必再进一步自行封装了。

具体请使用对应IDE打开SDK查看。package路径 `main.java.com.hanclouds.req`。

有任何疑问请加入QQ用户交流群：`587234791` 或者到瀚云社区直接发帖提问。[https://www.hanclouds.com/bbs](https://www.hanclouds.com/bbs)

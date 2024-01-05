#111
##33
###444
###表格

##### 简要描述

- 查询菜单

##### 请求URL
- ` http://106.14.127.215:31080/cavini/users/api/sysMenu/query/dataList `
  
##### 请求方式
- POST 

##### 请求示例
无


##### 返回示例 

``` 
{
	"resultCode": "000000",
	"resultMsg": "success",
	"data": {
		"resultList": [{
			"id": 1,
			"parentId": 0,
			"menuName": "工作台",
			"menuUrl": "",
			"menuLevel": 1,
			"menuNo": 1,
			"seq": 1,
			"childNodes": [{
				"id": 2,
				"parentId": 1,
				"menuName": "消息通知",
				"menuUrl": "",
				"menuLevel": 2,
				"menuNo": 1,
				"seq": 1,
				"childNodes": [{
					"id": 3,
					"parentId": 2,
					"menuName": "查询列表",
					"menuUrl": "/xxx/xxx/xxx",
					"menuLevel": 3,
					"menuNo": 1,
					"seq": 1
				}]
			}]
		}]
	}
}
```

##### 返回参数说明 

|参数名|类型|说明|
|:-----  |:-----|-----|
|resultCode |String   |返回状态码，000000-成功  |
|resultMsg |String   |返回描述  |
|data |Object   |数据信息  |

##### 返回参数说明(data)

|参数名|类型|说明|
|:-----  |:-----|-----|
|resultList |List   |数据列表  |

##### 返回参数说明(resultList)

|参数名|类型|说明|
|:-----  |:-----|-----|
|id |Long |主键ID  |
|parentId |Integer |父ID |
|menuName |String |菜单名  |
|menuUrl |String |路径  |
|menuLevel |Integer |菜单层级  |
|menuNo |Integer |菜单编号  |
|seq |Integer |排序号 |
|childNodes |Object[] |对象数组，子节点 |




# Mor-Wai
> "หมอไว" Services for mental disorder (Depression) prevention and medical care.
## Presentation
> Slide: https://docs.google.com/presentation/d/1BZIsB1y6jIJ1eJHjpqhmk_XVLO7OzJEHKhPe7wGumFA/edit?usp=sharing
## Features
- ### Depression Inventory Test Services (แบบทดสอบประเมิณอาการโรคซึมเศร้า)
	- มีที่มาจากการศึกษางานวิจัยโรคซึมเศร้า, การปรึกษาแพทย์ และ นำมาทำเป็นแบบทดสอบโรคซึมเศร้าเพื่อประเมิณอาการโรคซึมเศร้าและประเภทของโรคซึมเศร้าที่เป็น
### 🌱  Usage
- #### ⭐ Get questions
  URL :  `test/questions`
  Method :  `GET`
  **Response**
  Code :  `200`
  Example response :
```json
[
	{
		"questionID":  1,
		"questionTitle":  "รู้สึกซึม เศร้า หงุดหงิด หรือสิ้นหวัง",
		"choices":  [
			{
				"choiceID":  0,
				"choiceTitle":  "ไม่มีเลย",
				"choiceValue":  0
			},
			{
				"choiceID":  1,
				"choiceTitle":  "มีบางวัน",
				"choiceValue":  1
			},
			{
				"choiceID":  2,
				"choiceTitle":  "มีมากกว่า 7 วัน",
				"choiceValue":  2
			},
			{
				"choiceID":  3,
				"choiceTitle":  "มีแทบทุกวัน",
				"choiceValue":  3
			}
		]
	},
	...
	{
		"questionID":  9,
		"questionTitle":  "คิดว่าถ้าตายไปเสียจะดีกว่า หรือคิดจะทำร้ายตัวเองด้วยวิธีใดวิธีหนึ่ง",
		"choices":  [
			{
				"choiceID":  0,
				"choiceTitle":  "ไม่มีเลย",
				"choiceValue":  0
			},
			{
				"choiceID":  1,
				"choiceTitle":  "มีบางวัน",
				"choiceValue":  1
			},
			{
				"choiceID":  2,
				"choiceTitle":  "มีมากกว่า 7 วัน",
				"choiceValue":  2
			},
			{
				"choiceID":  3,
				"choiceTitle":  "มีแทบทุกวัน",
				"choiceValue":  3
			}
		]
	}
]
```

- #### ⭐ Get questions by ID
  URL :  `test/questions/{id}`
  Method :  `GET`
  **Response**
  Code :  `200`
  Example response :
```json
{
	"questionID":  1,
	"questionTitle":  "รู้สึกซึม เศร้า หงุดหงิด หรือสิ้นหวัง",
	"choices":  [
		{
			"choiceID":  0,
			"choiceTitle":  "ไม่มีเลย",
			"choiceValue":  0
		},
		{
			"choiceID":  1,
			"choiceTitle":  "มีบางวัน",
			"choiceValue":  1
		},
		{
			"choiceID":  2,
			"choiceTitle":  "มีมากกว่า 7 วัน",
			"choiceValue":  2
		},
		{
			"choiceID":  3,
			"choiceTitle":  "มีแทบทุกวัน",
			"choiceValue":  3
		}
	]
}
```

- #### ⭐ Interpretation
  URL :  `test/interpretation`
  Method :  `POST`
  **Response**
  Code :  `200`
  Example body :
```json
{
	"answers": [
		{
			"questionID": 1,
			"selectedChoice": 1
		},
		{
			"questionID": 2,
			"selectedChoice": 1
		},
		{
			"questionID": 3,
			"selectedChoice": 1
		},
		{
			"questionID": 4,
			"selectedChoice": 1
		},
		{
			"questionID": 5,
			"selectedChoice": 1
		},
		{
			"questionID": 6,
			"selectedChoice": 1
		},
		{
			"questionID": 7,
			"selectedChoice": 1
		},
		{
			"questionID": 8,
			"selectedChoice": 1
		},
		{
			"questionID": 9,
			"selectedChoice": 1
		}
	]
}
```
  Example response :
```json
{
	"totalScore":  9,
	"depressionSeverity":  "มีภาวะซึมเศร้าเล็กน้อย"
}
```

---
- ### Authentication Services
- **Get authentication token**
	
	**`POST`** auth/oauth/token
	
	**Request**

	```
	Authorize Basic

	username : fooClientId
	password : secret
	```
	```
	URL Parameters

	grant_type : password
	username : <username>
	password: <password>
	scope: read write
	```

	**Response**
	```json
	{
		"access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Nzc0ODAxNjksInVzZXJfbmFtZSI6InBob25nc2F0aG9ybiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiIwZWIzODM3Yi03ODZkLTQ0NjUtOTY2Ni1lYWFlNjE5MTM2NTkiLCJjbGllbnRfaWQiOiJmb29DbGllbnRJZCIsInNjb3BlIjpbInJlYWQiXX0.q-OpfpNeSaeedB8QRvp8bCDXMDc4uwIfDj9GyGEugBk",
		"token_type": "bearer",
		"refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJwaG9uZ3NhdGhvcm4iLCJzY29wZSI6WyJyZWFkIl0sImF0aSI6IjBlYjM4MzdiLTc4NmQtNDQ2NS05NjY2LWVhYWU2MTkxMzY1OSIsImV4cCI6MTU3NzU2NjU2OSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImUwMDA4YzQ1LTNkZTMtNDJhZS1hOWZmLTAyNTlhN2VkODk0YSIsImNsaWVudF9pZCI6ImZvb0NsaWVudElkIn0.pDbeYc_P1MKmr3vUJBx087fMSsoBp_y2fxnTq018q8c",
		"expires_in": 2561746,
		"scope": "read",
		"jti": "0eb3837b-786d-4465-9666-eaae61913659"
	}\
	```

- **Check authentication token**

	**`GET`** auth/oauth/check_token

	**Request**

	```
	Authorize Basic

	username : fooClientId
	password : secret
	```

	```
	URL Parameters

	token: <token>
	```

	**Response**

	```json
	{
		"user_name": "phongsathorn",
		"scope": [
			"read"
		],
		"active": true,
		"exp": 1577482177,
		"authorities": [
			"ROLE_USER"
		],
		"jti": "9bd13c7f-60db-4bf4-81ef-6e6e44319ce1",
		"client_id": "fooClientId"
	}
	```

- **Check authentication token**

	**`GET`** auth/api/v1.0/me

	**Request**

	```
	Authorize Bearer <token>
	```

	**Response**

	```json
	{
	"id": 2,
		"username": "phongsathorn",
		"firstname": "Phongsathorn",
		"lastname": "Kittiworapanya",
		"email": "phongsathron@outlook.com",
		"role": "ROLE_USER",
		"_enabled": true
	}
	```

- **Register client**

	**`GET`** auth/client/register

	**Request**
	```
	Authorize Bearer <token>
	```

	```
	Multipart form

	name: <client name>
	email: <developer email>
	homepageUrl: <product homepage>
	description: <product description>
	redirectUrl: <OAuth2 redirect url>
	```

	**Response**
	```json
	{
		"id": 4,
		"version": null,
		"oauth_client_id": {
			"id": null,
			"version": null,
			"clientId": "f6f7fdbe-6acc-4594-a234-3e0ee3c74ee2",
			"resourceIds": null,
			"clientSecret": "jknREJSIAOZqsXAXRg3OL6f4iqvc8H",
			"scope": "read,write",
			"grantTypes": "password,authorization_code,refresh_token",
			"webServerRedirectUri": "https://www.google.com/",
			"authorities": "ROLE_USER",
			"accessTokenValidity": 2592000,
			"refreshTokenValidity": 2678400,
			"additionalInfo": null,
			"autoApprove": null
		},
		"name": "TestClient2",
		"email": "client1@outlook.com",
		"homepageUrl": "https://www.google.com/",
		"description": "This is test client 1"
	}
	```

- **Client Authorize**

	**`GET`** auth/oauth/authorize

	**Request**

	```
	URL Parameters

	client_id: <client_id>
	response_type: code
	redirect_uri: <redirect_uri>
	```

- **User register**

	**`POST`** auth/api/v1.0/register

	**Request**

	```json
	JSON request

	{
		"username": "phongsathorn",
		"firstname": "Phongsathorn",
		"lastname": "Kittiworapanya",
		"password": "password",
		"email": "phongsathron@outlook.com",
		"role": "ROLE_USER"
	}
	```



---
- ### Hospital Location Service
	-	ค้นหาโรงพยาบาลที่ใกล้เคียงซึ่งมีจิตแพทย์พร้อมให้การรักษา
  - 🌱 Usage
    - get all location
    ```
        GET hospital/location/
    ```

    ```python
      # Response Type
        [
          {
              "id": int,
              "name": string,
              "description": string,
              "created_at": string,
              "latitude": float,
              "longitude": float
          }
        ]
    ```
    - add location
    ```
        POST hospital/location/
    ```
    ```python
        # Payload Type
        [
          {
            "name": string,
            "description": string,
            "latitude": float,
            "longitude": float
          }
        ]
    ```

    - get specific location
    ```
        GET hospital/location/<id>
    ```

    ```python
      # Response Type
        {
          "id": int,
          "name": string,
          "description": string,
          "created_at": string,
          "latitude": float,
          "longitude": float
        }
    ```

    - edit location infomation
    ```
        PATCH hospital/location/<id>
    ```
    ```
        PUT hospital/location/<id>
    ```

    ```python
        # Payload Type
        # PUT requires all fields, patch otherwise
        [
          {
              "name": string,
              "description": string,
              "latitude": float,
              "longitude": float
          }
        ]
    ```

    - delete location infomation
    ```
        DELETE hospital/location/<id>
    ```

    - get filter location using user location
    ```
        GET hospital/location/filter
    ```
    ```python
        # Parameter
        lat = "float: user's latitude"
        lon = "float: user's longitude"
        km = "float: filter distance"
    ```
    ```python
        # Response Type
        [
          {
              "id": int,
              "name": string,
              "description": string,
              "created_at": string,
              "latitude": float,
              "longitude": float
          }
        ]
    ```

---
- ### Treatment Recommendations Services
	- ให้คำแนะนำเกี่ยวกับการรักษาโรคซึมเศร้า ทั้งในด้านการดูแลตนเองและแนวทางการรักษาของแพทย์
	- ทำการรับคะแนนที่ได้จาก Depression Test Service มาให้คำแนะนำในการรักษา<br>
		- รับคำแนะนำการรักษา
		**URL**: `suggest/suggest/suggestion/{total_score}` **Method**: `GET`
		***หมายเหตุ : เพื่อป้องกันข้อผิดพลาดด้านการแสดงผลกรุณาใช้ Postman**  
			- Get Suggestion
			- **Response :**
		```json
		{

		"id": 5,

		"depressed_level": "มีภาวะซึมเศร้าปานกลาง",

		"text": "ควรพักผ่อนให้เพียงพอ นอนหลับให้ได้ 6-8 ชั่วโมง ออกกำลังกายสม่ำเสมอ ทำกิจกรรมที่ทำให้ผ่อนคลาย พบปะเพื่อนฝูง ควรขอคำปรึกษาช่วยเหลือจากผู้ที่ไว้วางใจ ไม่จมอยู่กับปัญหา มองหาหนทางคลี่คลาย หากอาการที่ท่านเป็นมีผลกระทบต่อการทำงานหรือการเข้าสังคม (อาการซึมเศร้าทำให้ท่านมีปัญหาในการทำงาน การดูแลสิ่งต่างๆ ในบ้าน หรือการเข้ากับผู้คน ในระดับมากถึงมากที่สุด) หรือหากท่านมีอาการระดับนี้มานาน 1-2 สัปดาห์แล้วยังไม่ดีขึ้น ควรพบแพทย์เพื่อรับการช่วยเหลือรักษา"

		}
		```
		- ดูคำแนะนำการรักษาทั้งหมด
		**URL :** `suggest/suggest/suggestion_list` **Method**: `GET`
		***หมายเหตุ : เพื่อป้องกันข้อผิดพลาดด้านการแสดงผลกรุณาใช้ Postman**
			- Get Suggestion List
			- **Response**
		```json
		[

		{

		"id": 3,

		"depressed_level": "ไม่มีภาวะซึมเศร้า",

		"text": "ไม่จำเป็นต้องรักษา"

		},

		{

		"id": 4,

		"depressed_level": "มีภาวะซึมเศร้าเล็กน้อย",

		"text": "ควรพักผ่อนให้เพียงพอ นอนหลับให้ได้ 6-8 ชั่วโมง ออกกำลังกายสม่ำเสมอ ทำกิจกรรมที่ทำให้ผ่อนคลาย พบปะเพื่อนฝูง ควรทำแบบประเมินอีกครั้งใน 1 สัปดาห์"

		},

		{

		"id": 5,

		"depressed_level": "มีภาวะซึมเศร้าปานกลาง",

		"text": "ควรพักผ่อนให้เพียงพอ นอนหลับให้ได้ 6-8 ชั่วโมง ออกกำลังกายสม่ำเสมอ ทำกิจกรรมที่ทำให้ผ่อนคลาย พบปะเพื่อนฝูง ควรขอคำปรึกษาช่วยเหลือจากผู้ที่ไว้วางใจ ไม่จมอยู่กับปัญหา มองหาหนทางคลี่คลาย หากอาการที่ท่านเป็นมีผลกระทบต่อการทำงานหรือการเข้าสังคม (อาการซึมเศร้าทำให้ท่านมีปัญหาในการทำงาน การดูแลสิ่งต่างๆ ในบ้าน หรือการเข้ากับผู้คน ในระดับมากถึงมากที่สุด) หรือหากท่านมีอาการระดับนี้มานาน 1-2 สัปดาห์แล้วยังไม่ดีขึ้น ควรพบแพทย์เพื่อรับการช่วยเหลือรักษา"

		},

		{

		"id": 6,

		"depressed_level": "มีภาวะซึมเศร้ามาก",

		"text": "ควรพบแพทย์เพื่อประเมินอาการและให้การรักษา ระหว่างนี้ควรพักผ่อนให้เพียงพอ นอนหลับให้ได้ 6-8 ชั่วโมง ออกกำลังกายเบาๆ ทำกิจกรรมที่ทำให้ผ่อนคลาย ไม่เก็บตัว และควรขอคำปรึกษาช่วยเหลือจากผู้ใกล้ชิด"

		},

		{

		"id": 7,

		"depressed_level": "มีภาวะซึมเศร้ารุนแรง",

		"text": "ต้องพบแพทย์เพื่อประเมินอาการและให้การรักษาโดยด่วน ไม่ควรปล่อยทิ้งไว้"

		}

		]
		```

---
- ### Up-Coming Events Service
	- แนะนำ Events ที่มีส่วนช่วยพัฒนาสุขภาพจิต และ ป้องกัน Mental Disorder ที่ถูกจัดขึ้นในประเทศไทย เช่น กิจกรรรมของ Chula-Wellness
	
# Depression

## Event Service

เป็น Service สำหรับการจัดการ Event ในโปรเจ็ค Depression โดยจะสามารถเพิ่ม ดูรายการ Event ทั้งหมด ดูแต่ละ Event และก็ลบ

### การเพิ่ม Event( URL : event/add , Method : Post)
Example :
```json
[
  {
    "event_name" : "KMITL_Marathon",
    "event_details" : "วิ่งเพื่อนการกุศล",
    "event_date" : "2020-01-22",
    "event_place" : "คณะเทคโนโลยีสารสนเทศ"
  }
]
```

### การเข้าดูในแต่ละ Event (URL : event/view, Method : GET)
	จะ Return กลับมาให้เป็น Json
Example :
```json
[
  {
     "event_name" : "Present_project",
     "event_datails" : "present mircroservice",
     "event_date" : "2020-3-21",
     "event_place" : "IT"
   }
]
```

### การลบ Event( URL : event/delete/{id} , Method : POST) ID ให้ใส่เลขที่ต้องการจะลบ

###  ดูแต่ละ Event (URL : event/view/{id} , Method : POST) ID ให้ใส่เลขที่ต้องการจะดู


## Use Case
![](images/usecase.png)

## Micro-Services Overview
![](images/overview.png)

## Team Member

**Group 14**

---

|<img width="100px" src="images/phongsathorn.jpg" alt="Phongsathorn Kittiworapanya">|<img width="100px" src="https://avatars1.githubusercontent.com/u/33230187?s=60&v=4">|<img width="100px" src="https://avatars3.githubusercontent.com/u/32861458?s=150&v=4">|<img width="100px" src="images/warit.jpg">|<img width="100px" src="https://avatars2.githubusercontent.com/u/33046403?s=60&v=4">|
|--|--|--|--|--|
|พงศธร กิตติวรปัญญา|ภูรี กานุสิทธิ์|ภาสวิชญ์ ริ้วทอง|วริศ การย์บรรจบ|ชญานิน ลำยอง|
|60070055|60070075|60070073|60070087|60070012|
|[@Phongsathron](https://github.com/Phongsathron)|[@realkyr](https://github.com/realkyr)|[@dekdew](https://github.com/dekdew)|[@WaiWarit](https://github.com/waiwarit)|[@azurelisz](https://github.com/azurelisz)|
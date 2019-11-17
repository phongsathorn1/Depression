
# Mor-Wai
> "หมอไว" Services for mental disorder (Depression) prevention and medical care.
## Features
- ### Depression Inventory Test Services (แบบทดสอบประเมิณอาการโรคซึมเศร้า)
	- มีที่มาจากการศึกษางานวิจัยโรคซึมเศร้า, การปรึกษาแพทย์ และ นำมาทำเป็นแบบทดสอบโรคซึมเศร้าเพื่อประเมิณอาการโรคซึมเศร้าและประเภทของโรคซึมเศร้าที่เป็น
### 🌱  Usage
- #### ⭐ Get questions
  URL :  `/questions`
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
  URL :  `/questions/{id}`
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
  URL :  `/interpretation`
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
- ### User Services
	- Authentication part
	- User's Profile

---
- ### Hospital Location Service
	-	ค้นหาโรงพยาบาลที่ใกล้เคียงซึ่งมีจิตแพทย์พร้อมให้การรักษา

---
- ### Treatment Recommendations Services
	- ทำการติดต่อประสานงานกับแพทย์ หรือ โรงพยาบาลใกล้เคียงซึ่งมีจิตแพทย์ให้การรักษา
	- ให้คำแนะนำเกี่ยวกับการรักษาโรคซึมเศร้า ทั้งในด้านการดูแลตนเองและแนวทางการรักษาของแพทย์

---
- ### Up-Coming Events Service
	- แนะนำ Events ที่มีส่วนช่วยพัฒนาสุขภาพจิต และ ป้องกัน Mental Disorder ที่ถูกจัดขึ้นในประเทศไทย เช่น กิจกรรรมของ Chula-Wellness

## Use Case
![](image/usecase.png)

## Micro-Services Overview
![](image/microservices_overview.png)

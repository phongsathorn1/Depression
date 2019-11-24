# Depression

## Event Service

เป็น Service สำหรับการจัดการ Event ในโปรเจ็ค Depression โดยจะสามารถเพิ่ม ดูรายการ Event ทั้งหมด ดูแต่ละ Event และก็ลบ

### การเพิ่ม Event( URL : /add , Method : Post)
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

### การเข้าดูในต่ละ Event (URL : /view, Method : GET)
จะ Return กลับมาให้เป็น Json

### การลบ Event( URL : /delete/{id} , Method : POST) ID ให้ใส่เลขที่ต้องการจะลบ

###  ดูแต่ละ Event (URL : /view/{id} , Method : POST) ID ให้ใส่เลขที่ต้องการจะดู




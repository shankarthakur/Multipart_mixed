# Multipart_mixed


Run command : curl -i -X POST -H "Content-Type: multipart/mixed; boundary=boundary-delimiter" -F "somepayload={\"userId\":\"12\",\"name\":\"shankar\",\"contact\":\"9999123\"};type=application/json" -F "uploadfile=@C:\Users\shankasi\Downloads\sample\audio2.wav" http://localhost:8080/request --insecure

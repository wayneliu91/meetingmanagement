1. 预定会议室   <br/>
   请求方式：POST    <br/>
   请求 URL：http://localhost:8080/meetings/book   <br/>
   请求参数：    <br/>
   title：会议标题   <br/>
   startTime：会议开始时间（格式：yyyy-MM-ddTHH:mm:ss） <br/>
   endTime：会议结束时间（格式：yyyy-MM-ddTHH:mm:ss）   <br/>
   roomId：会议室 ID    <br/>
   userId：用户 ID <br/>
   isHosted：是否为主持会议 <br/>

2. 个人参会列表
   请求方式：GET
   请求 URL：http://localhost:8080/meetings/user/{userId}

3. 参会最优解
   请求方式：GET
   请求 URL：http://localhost:8080/meetings/user/{userId}/optimal
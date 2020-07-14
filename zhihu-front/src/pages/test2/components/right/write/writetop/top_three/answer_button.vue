<template>
  <div id="answer_button">
    <el-button type="text" style=width:100%;height:100%;padding:0px;text-align:center>
      <i class="el-icon-tickets"/>
      <p>写回答</p>
      </el-button>
  </div>
</template>
<script>
export default {
  name: 'answer_button'
}
</script>

<style scoped>

#answer_button {
  vertical-align: top;
  display: inline-block;
  margin-left: 10px;
  padding: 20px;
  height: 50px;
  width: 52px;
  background-color: white
}
i{
  color: #8590a6;
  font-size: 25px;
}
p{
  color: #8590a6;
  margin-top: 10px;
}
p:hover{
  color: #0997F7;
}
</style>

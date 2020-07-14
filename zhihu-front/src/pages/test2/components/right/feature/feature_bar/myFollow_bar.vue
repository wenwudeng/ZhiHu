<template>
  <div id="MyFollow_bar">
     <el-button type="text" style="width:100%;text-align:left">
      <i class="el-icon-question"/>
      <span>我关注的问题</span>
    </el-button>
  </div>
</template>
<script>
export default {
  name: 'MyFollow_bar'
}
</script>

<style scoped>

#MyFollow_bar {
  padding: 0px 20px;
  height: 40px;
  width: 256px;
  background-color: white;
}
i{
  color: #8590a6;
}
span{
  color: #8590a6;
  padding: 0px 10px;
}
#MyFollow_bar:hover{
  background-color:#E3E3E3;
}
</style>

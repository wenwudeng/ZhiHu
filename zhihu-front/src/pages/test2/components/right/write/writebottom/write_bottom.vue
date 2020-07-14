<template>
  <div id="write_bottom">
    <el-button type="text" style="width:100%;text-align:left">
      <i class="el-icon-time"/>
      <span>我的稍后答</span>
    </el-button>
  </div>
</template>
<script>
export default {
  name: 'write_bottom'
}
</script>

<style scoped>

#write_bottom {
  padding: 0px 20px;
  height: 40px;
  width: 256px;
  background-color: white;
}
i{
  color: #8590a6;
}
span{
  padding: 0px 10px;
  color: #8590a6;
}
#write_bottom:hover{
  background-color:#E3E3E3;
}
</style>

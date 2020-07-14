<template>
  <div id="MyCollect_bar">
    <el-button type="text" style="width:100%;text-align:left">
      <i class="el-icon-star-on"/>
      <span>我的收藏</span>
    </el-button>
  </div>
</template>
<script>
export default {
  name: 'MyCollect_bar'
}
</script>

<style scoped>

#MyCollect_bar {
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
#MyCollect_bar:hover{
  background-color:#E3E3E3;
}
</style>

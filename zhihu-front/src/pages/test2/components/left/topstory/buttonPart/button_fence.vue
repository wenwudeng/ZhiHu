<template>
  <div id="button_part">
    <el-button type="text" style=width:100%;height:100%;padding:0px;text-align:center>
      <p>{{ names }}</p>
    </el-button>
  </div>
</template>
<script>
export default {
  props: ['names']
}
</script>
<style scoped>
#button_part {
  margin-left: 20px;
  margin-right: 20px;
  vertical-align: top;
  display: inline-block;
  height: 58px;
  width: 32px;
  background-color: white
}
p{
  font-size: 16px;
  color: black;
  margin-top: 20px;
}
p:hover{
  color: #0997F7;
}
</style>

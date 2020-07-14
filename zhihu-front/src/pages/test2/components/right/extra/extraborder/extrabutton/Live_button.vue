<template>
  <div id="Live_button">
      <el-button type="text" style=width:100%;height:100%;padding:0px;text-align:center>
      <i class="el-icon-s-promotion"/>
      <p>Live</p>
      </el-button>
  </div>
</template>
<script>
export default {
  name: 'Live_button'
}
</script>

<style scoped>

#Live_button {
  margin-top: 10px;
  vertical-align: top;
  display: inline-block;
  height: 55px;
  width: 88px;
  background-color: white
}
i{
  color: yellow;
  font-size: 25px;
}
p{
  color: #8590a6;
  margin-top: 10px;
}
p:hover{
  color: yellow;
}
</style>

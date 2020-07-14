<template>
  <div id="BookStore_button">
    <el-button type="text" style=width:100%;height:100%;padding:0px;text-align:center>
      <i class="el-icon-notebook-1"/>
      <p>书店</p>
      </el-button>
  </div>
</template>
<script>
export default {
  name: 'BookStore_button'
}
</script>

<style scoped>

#BookStore_button {
  margin-top: 10px;
  vertical-align: top;
  display: inline-block;
  height: 55px;
  width: 88px;
  background-color: white
}
i{
  color: green;
  font-size: 25px;
}
p{
  color: #8590a6;
  margin-top: 10px;
}
p:hover{
  color: green;
}
</style>

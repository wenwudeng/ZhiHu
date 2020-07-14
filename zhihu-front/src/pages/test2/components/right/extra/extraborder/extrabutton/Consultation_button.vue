<template>
  <div id="Consultation_button">
    <el-button type="text" style=width:100%;height:100%;padding:0px;text-align:center>
      <i class="el-icon-coin"/>
      <p>付费咨询</p>
      </el-button>
  </div>
</template>
<script>
export default {
  name: 'Consultation_button'

}
</script>

<style scoped>

#Consultation_button {
  margin-top: 10px;
  vertical-align: top;
  display: inline-block;
  height: 55px;
  width: 88px;
  background-color: white
}
i{
  color: blue;
  font-size: 25px;
}
p{
  color: #8590a6;
  margin-top: 10px;
}
p:hover{
  color: blue;
}
</style>

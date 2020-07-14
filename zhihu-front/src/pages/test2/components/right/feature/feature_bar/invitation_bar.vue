<template>
  <div id="invitation_bar">
    <el-button type="text" style="width:100%;text-align:left">
      <i class="el-icon-user-solid"/>
      <span>我的邀请</span>
    </el-button>
  </div>
</template>
<script>
export default {
  name: 'invitation_bar'
}
</script>

<style scoped>

#invitation_bar {
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
#invitation_bar:hover{
  background-color:#E3E3E3;
}
</style>

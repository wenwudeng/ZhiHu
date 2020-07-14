<template>
  <div id="top_Part">
    <el-radio-group>
    <router-link to='contentBox'><el-button>推荐</el-button></router-link>
    <router-link to='follow'><el-button>关注</el-button></router-link>
    <router-link to='hot'><el-button>热榜</el-button></router-link>
    </el-radio-group>
  </div>
</template>

<script>
export default {
}
</script>
<style style scoped>

.el-button--default{
  font-size: 16px;
  width: 75px;
  height: 100%;
  padding: 0px;
  text-align: center;
  border: 0px;
}
.el-button--default:focus{
   background-color: white;
   color:#0997F7;
}
.el-button--default:hover{
  background-color: white;
  color: #0997F7;
}
</style>

<style scoped>

#top_Part {
  padding: 20px 0px;
  height: 19px;
  width: 100%;
  border-bottom: 1px solid #DDDDDD;
  background-color: white
}
</style>

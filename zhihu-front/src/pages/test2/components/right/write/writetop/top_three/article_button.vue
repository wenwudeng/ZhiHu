<template>
  <div id="article_button">
    <router-link to='/Home/index/writeArticle'><el-button type="text" style=width:100%;height:100%;padding:0px;text-align:center>
      <i class="el-icon-edit-outline"/>
      <p>写文章</p>
    </el-button>
    </router-link>
  </div>
</template>
<script>
export default {
  name: 'article_button'
}
</script>

<style scoped>

#article_button {
  vertical-align: top;
  display: inline-block;
  padding: 20px;
  height: 50px;
  width: 52px;
  background-color: white;
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

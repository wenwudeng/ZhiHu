<template>
  <div id="article">
    <TopBar></TopBar>
    <router-view/>
    <!-- <ContentBox></ContentBox> -->
  </div>
</template>

<script>
import TopBar from '../left/topstory/topbar'
export default {
  components: {
    'TopBar': TopBar
  }
}
</script>

<style scoped>

#article {
  margin-top: 10px;
  display: inline-block;
  margin-left: 250px;
  height: 52px;
  width: 695px;
  background-color: white;
  -moz-box-shadow: 0px 0px 1px gray;
  -webkit-box-shadow:0px 0px 1px gray;
  box-shadow:0px 0px 1px gray;
  border-radius:5px;
}
</style>

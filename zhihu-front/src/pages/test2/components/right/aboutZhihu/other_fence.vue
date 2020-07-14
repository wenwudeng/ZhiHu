<template>
  <div id="other_part">
    <div id="rowSpace">
      <a href="#">刘看山</a><Point/>
      <a href="#">知乎指南</a><Point/>
      <a href="#">知乎协议</a><Point/>
      <a href="#">知乎隐私保护指引</a>
    </div>
    <div id="rowSpace">
      <a href="#">应用</a><Point/>
      <a href="#">工作</a><Point/>
      <a href="#">申请开通知乎机构号</a><br>
    </div>
    <div id="rowSpace">
      <a href="#">侵权举报</a><Point/>
      <a href="#">网上有害信息举报专区</a><br>
    </div>
    <div id="rowSpace">
      <div id="word1">违法和不良信息举报：010-82716601</div>
    </div>
    <div id="rowSpace">
      <a href="#">儿童色情信息举报专区</a><br>
    </div>
    <div id="rowSpace">
      <a href="#">证照中心</a><br>
    </div>
      <div id="rowSpace">
      <a href="#">联系我们</a><div id="word2">© 2019 知乎</div>
    </div>
  </div>
</template>
<script>
import Point from '../aboutZhihu/otherPart/other_point'
export default {
  components: {
    'Point': Point
  }
}
</script>

<style scoped>
a{
  margin-top: 10px;
  font-size: 13px;
  color:#8590a6;
  text-decoration:none;
}
#rowSpace{
  margin-top: 10px;
}
#word1{
  font-size: 13px;
  color:#8590a6;
}
#word2{
  display: inline-block;
  font-size: 13px;
  color:#8590a6;
}
#other_part {
  vertical-align: top;
  margin-top: 10px;
  display: inline-block;
  height: 220px;
  width: 100%;
}
</style>

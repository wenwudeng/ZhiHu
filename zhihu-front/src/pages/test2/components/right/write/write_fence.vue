<template>
  <div id="write_part">
    <WriteTop></WriteTop>
    <WriteBottom></WriteBottom>
  </div>
</template>
<script>
import WriteTop from '../write/writetop/write_top'
import WriteBottom from '../write//writebottom/write_bottom'
export default {
  name: 'write_part',
  components: {
    'WriteTop': WriteTop,
    'WriteBottom': WriteBottom
  }
}
</script>

<style scoped>

#write_part {
  vertical-align: top;
  display: inline-block;
  height: 145px;
  width: 100%;
  background-color: white;
  -moz-box-shadow: 0px 0px 1px gray;
  -webkit-box-shadow:0px 0px 1px gray;
  box-shadow:0px 0px 1px gray;
  border-radius:5px;
}
</style>

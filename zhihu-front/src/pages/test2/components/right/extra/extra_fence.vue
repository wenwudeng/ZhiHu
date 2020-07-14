<template>
  <div id="extra_part">
    <ExtraBorder></ExtraBorder>
  </div>
</template>
<script>
import ExtraBorder from '../extra/extraborder/extra_border'
export default {
  components: {
    'ExtraBorder': ExtraBorder
  }
}
</script>

<style scoped>

#extra_part {
  vertical-align: top;
  margin-top: 10px;
  display: inline-block;
  height: 150px;
  width: 100%;
  background-color:white;
  -moz-box-shadow: 0px 0px 1px gray;
  -webkit-box-shadow:0px 0px 1px gray;
  box-shadow:0px 0px 1px gray;
  border-radius:5px;
}
</style>

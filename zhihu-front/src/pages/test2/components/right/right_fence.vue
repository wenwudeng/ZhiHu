<template>
  <div id="aside">
    <WritePart></WritePart>
    <ExtraPart></ExtraPart>
    <FeaturePart></FeaturePart>
    <OtherPart></OtherPart>
  </div>
</template>

<script>
import WritePart from '../right/write/write_fence.vue'
import ExtraPart from '../right/extra/extra_fence.vue'
import FeaturePart from '../right/feature/feature_fence.vue'
import OtherPart from '../right/aboutZhihu/other_fence.vue'
export default {
  name: 'Aside',
  components: {
    'WritePart': WritePart,
    'ExtraPart': ExtraPart,
    'FeaturePart': FeaturePart,
    'OtherPart': OtherPart
  }
}
</script>

<style scoped>

#aside {
  margin-top: 10px;
  vertical-align: top;
  display: inline-block;
  margin-left: 5px;
  height: 800px;
  width: 296px;
}
</style>

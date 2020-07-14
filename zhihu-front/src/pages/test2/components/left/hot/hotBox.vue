<template>
  <div id="hot_box">
      <HotFence></HotFence>
  </div>
</template>

<script>
import HotFence from '../hot/hotfence/hot_fence'
export default {
  name: 'hot_box',
  components: {
    'HotFence': HotFence
  }
}

</script>

<style scoped>
#hot_box{
  height: 100px;
  width: 100%;
}
</style>

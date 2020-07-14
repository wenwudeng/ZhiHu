<template>
  <div id="thinking_button">
    <el-button type="text" @click="open" style=width:100%;height:100%;padding:0px;text-align:center>
      <i class="el-icon-chat-dot-round"/>
      <p>写想法</p>
    </el-button>
  </div>
</template>
<script>
export default {
  name: 'thinking_button',
  methods: {
    open () {
      this.$alert('这是一段内容', '标题名称', {
        confirmButtonText: '确定'
      })
    }
  }
}
</script>

<style scoped>

#thinking_button {
  vertical-align: top;
  display: inline-block;
  padding: 20px;
  height: 50px;
  width: 52px;
  background-color: white
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

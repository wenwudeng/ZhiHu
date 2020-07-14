<template>
 <div class="App-main">
                   <!--之后用来替换header-->
            <!-- <div class="header"></div> -->
            <vheader></vheader>

                   <!-- 上传主题图片区域 -->
            <div class="WriteIndexLayout-main">
                  <div class="WirteCover-wrapper">
                          <el-upload
                          class="avatar-uploader"
                          action="https://jsonplaceholder.typicode.com/posts/"
                          :show-file-list="false"
                          :on-success="handleAvatarSuccess"
                          :before-upload="beforeAvatarUpload">
                          <img v-if="imageUrl" :src="imageUrl" class="avatar">
                          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                  </div>
                  <!-- 输入标题区域 -->
                  <div>
                      <div class="WriteIndex-titleInput Input-wrapper Input-wrapper--multiline">
                      <textarea rows="1" class="Input" placeholder="请输入标题(最多五十个字)" style="height:44px" ></textarea>
                      </div>
                  </div>
                  <!-- 富文本编辑器区域 -->
                  <div class="PostEditor">
                  <quill-editor ref="myTextEditor" v-model="content" :options="editorOption"></quill-editor>
                  </div>
            </div>
  </div>
</template>

<script>
import vheader from '../../components/Home'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import { quillEditor } from 'vue-quill-editor'
export default {
  name: 'editor',
  data: function () {
    return {
      content: '',
      editorOption: {
        placeholder: '请输入内容'
      },
      imageUrl: ''
    }
  },
  components: {
    quillEditor,
    'vheader': vheader
  },
  methods: {
    onEditorChange ({ editor, html, text }) {
      this.content = html
    },
    submit () {
      console.log(this.content)
      this.$message.success('提交成功！')
    },
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 3

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 3MB!')
      }
      return isJPG && isLt2M
    }
  }
}

</script>

<style scoped>

    .header{
        width: 100%;
        height: 52px;
        background-color: rgb(12, 98, 209);
    }
    .WriteIndexLayout-main{
        margin: 47px auto 0;
        width: 660px;
    }
    .WirteCover-wrapper{
        background-color: #f6f6f6;
        line-height: 192px;
        color: gray;
        text-align: center;
    }

    /*对标题输入框的修饰  */
    .Input-wrapper.Input-wrapper--multiline {
    height: auto;
    }
    .WriteIndex-titleInput {
    margin: 16px 0;
    border: 0;
    padding: 0;
    height: auto;
    width: 100%;
    position: relative;
    }

    .WriteIndex-titleInput .Input {
    min-height: 44px;
    display: block;
    width: 100%;
    height: auto;
    border: 0;
    font-size: 32px;
    line-height: 1.4;
    font-weight: 600;
    outline: none;
    -webkit-box-shadow: none;
    box-shadow: none;
    }
    .Input {
    height: auto;
    -webkit-box-flex: 1;
    flex: 1 1;
    padding: 0;
    font-family: inherit;
    background: transparent;
    resize: none;
    }
    .Input-wrapper--multiline .Input {
    overflow: auto;
    }

    .PostEditor{
      padding: 0;
      height: auto;
      width: 100%;
    }

    /* 上传主题图片 */
    .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 100%;
    height: 100%;
    display: block;
  }

</style>

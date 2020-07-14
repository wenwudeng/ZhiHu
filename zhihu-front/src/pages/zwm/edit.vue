<template>
 <div>
                   <!--之后用来替换header-->
            <!-- <div class="header"></div> -->
            <vheader></vheader>

                   <!-- 上传主题图片区域  -->
            <div class="ProfileEdit">
                <div class="Card">
                  <div class="ProfileHeader-main">
                      <h3>当前头像：</h3>
                          <el-upload
                          class="avatar-uploader"
                          action="http://120.78.136.84:8090/api/user/uploadImage"
                          :show-file-list="false"
                          :on-success="handleAvatarSuccess"
                          :before-upload="beforeAvatarUpload">
                          <img v-if="imageUrl" :src="imageUrl" class="avatar">
                          <i v-else class="el-icon-camera avatar-uploader-icon"><span class="text">上传你的头像</span></i>
                          </el-upload>
                  </div>
                     <el-button type="primary" plain class="subButton" @click="setUserPortra">提交更改</el-button>
                </div>
            </div>
  </div>
</template>

<script>
import vheader from './vheader'
import { setUserPortrait } from '../../api/attent'
export default {
  data: function () {
    return {
      imageUrl: ''
    }
  },
  components: {
    'vheader': vheader
  },
  inject: ['reload'],
  methods: {
    handleAvatarSuccess (res, file) {
      console.info('res', res)
      console.info('file', file)
      // this.imageUrl = URL.createObjectURL(file.raw)
      this.imageUrl = res.data
      console.log(this.imageUrl)
      // 将上传完后的头像地址存入sessionStorage
      sessionStorage.setItem('imagUrl', this.imageUrl)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    setUserPortra () {
    //   this.userList[index].focus_type = !this.userList[index].focus_type
      let params = {
        userId: sessionStorage.getItem('userId'),
        portrait: this.imageUrl
      }
      setUserPortrait(params).then(res => {
        if (res.resultCode === 200) {
          this.testList = res.data
          // this.imageUrl = this.imageUrl
          // this.$router.push({ name: 'edit' })
          // this.reload()
          alert('修改头像成功')
          this.$router.go(0)
        }
      })
    }

  }
}

</script>

<style scoped>
.ProfileEdit {
width: 1000px;
padding: 0 16px;
margin: 14px auto;
font-size: 15px;
color: #1a1a1a;
}
.text{
  font-size: 15px;
  text-align: center;
  margin: 10px;
  padding: 10px;
}
h3{
  margin: 0px 5px 0px 250px;
}
.Card {
    margin-bottom: 10px;
    background: #fff;
    overflow: hidden;
    border-radius: 2px;
    -webkit-box-shadow: 0 1px 3px rgba(26,26,26,.1);
    box-shadow: 0 1px 3px rgba(26,26,26,.1);
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.ProfileHeader-avatar {
    position: absolute;
    top: -25px;
    left: 0;
    z-index: 1;
}
.UserAvatarEditor {
    cursor: pointer;
    position: relative;
}
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}
  .ProfileHeader-main {
    position: relative;
    margin: 0 20px 24px;
}
  .avatar-uploader  {
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
  .avatar-uploader{
    width: 178px;
    margin: 0 auto;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .subButton{
   float: right;
   margin-right: 150px;
   margin-bottom: 20px;
   background-color: #0077e6;
   color:#fff
  }
</style>

import Vue from 'vue';

import VueRouter from 'vue-router'
Vue.use(VueRouter);

import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/exampaperlist/exam'
    import news from '@/views/modules/news/list'
    import examfailrecord from '@/views/modules/examfailrecord/list'
    import examquestion from '@/views/modules/examquestion/list'
    import exampaper from '@/views/modules/exampaper/list'
    import storeup from '@/views/modules/storeup/list'
    import forum from '@/views/modules/forum/list'
    import kechengfenlei from '@/views/modules/kechengfenlei/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import exampaperlist from '@/views/modules/exampaperlist/list'
    import discusszaixianxuexi from '@/views/modules/discusszaixianxuexi/list'
    import zaixianxuexi from '@/views/modules/zaixianxuexi/list'
    import config from '@/views/modules/config/list'
    import examrecord from '@/views/modules/examrecord/list'
import recordlist from '@/views/modules/examrecord/recordlist'



const routes = [{
    path: '/index',
    name: 'Home',
    component: Index,
    children: [{

      path: '/',
      name: 'Home',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: 'Change password',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: 'pay',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: 'User Information',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/news',
        name: 'News',
        component: news
      }
          ,{
	path: '/examfailrecord',
        name: 'Wrong question',
        component: examfailrecord
      }
          ,{
	path: '/examquestion',
        name: 'Questions Management',
        component: examquestion
      }
          ,{
	path: '/exampaper',
        name: 'Quiz Management',
        component: exampaper
      }
          ,{
	path: '/storeup',
        name: 'Collection Management',
        component: storeup
      }
          ,{
	path: '/forum',
        name: 'Forum',
        component: forum
      }
          ,{
	path: '/kechengfenlei',
        name: 'Course Categories',
        component: kechengfenlei
      }
          ,{
	path: '/yonghu',
        name: 'User',
        component: yonghu
      }
          ,{
	path: '/chat',
        name: 'Online Q&A',
        component: chat
      }
          ,{
	path: '/exampaperlist',
        name: 'Quiz List',
        component: exampaperlist
      }
          ,{
	path: '/discusszaixianxuexi',
        name: 'Course Comment',
        component: discusszaixianxuexi
      }
          ,{
	path: '/zaixianxuexi',
        name: 'Course',
        component: zaixianxuexi
      }
          ,{
	path: '/config',
        name: 'Rotating image management',
        component: config
      }
          ,{
	path: '/examrecord',
        name: 'Quiz records',
        component: recordlist
      }
        ]
  },
  {
    path: '/adminexam',
    name: 'adminexam',
    component: adminexam,
    meta: {icon:'', title:'adminexam'}
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: 'Home',
    redirect: '/index'
  },
  {
    path: '*',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'hash',

  routes
})

export default router;

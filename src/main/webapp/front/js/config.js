var projectName = 'Teach Programming Website';

var swiper = {

  width: '100%',
  height: '400px',



  arrow: 'none',



  anim: 'default',


  interval: 2000,




  indicator: 'outside'
}


var centerMenu = [{
  name: 'User Information',
  url: '../' + localStorage.getItem('userTable') + '/center.html'
},
  {
    name: 'Posted',
    url: '../forum/list-my.html'
  },

  {
    name: 'Exam Record',
    url: '../examrecord/list.html'
  },
  {
    name: 'Wrong questions',
    url: '../examrecord/wrong.html'
  },
  {
    name: 'Collection Management',
    url: '../storeup/list.html'
  }
]


var indexNav = [

  {
    name: 'Course',
    url: './pages/course/list.html'
  },

  {
    name: 'Forum',
    url: './pages/forum/list.html'
  },
  {
    name: 'Quiz',
    url: './pages/exampaper/list.html'
  },
  {
    name: 'News',
    url: './pages/news/list.html'
  },
]

var adminurl = "http://localhost:8080/teach/admin/dist/index.html";

var cartFlag = false

var chatFlag = false


chatFlag = true


var menu = [{
  "backMenu": [{
    "child": [{
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "User",
      "menuJump": "list",
      "tableName": "yonghu"
    }], "menu": "User Management"
  }, {
    "child": [{
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "Course Categories",
      "menuJump": "list",
      "tableName": "kechengfenlei"
    }], "menu": "Course Category Management"
  }, {
    "child": [{
      "buttons": ["New", "view", "Modify", "Delete", "viewcomment"],
      "menu": "Course",
      "menuJump": "list",
      "tableName": "zaixianxuexi"
    }], "menu": "Course Management"
  }, {
    "child": [{"buttons": ["New", "view", "Modify", "Delete"], "menu": "Quiz Management", "tableName": "exampaper"}],
    "menu": "Quiz Management"
  }, {
    "child": [{
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "Questions Management",
      "tableName": "examquestion"
    }], "menu": "Questions Management"
  }, {
    "child": [{"buttons": ["New", "view", "Modify", "Delete"], "menu": "System Forum", "tableName": "forum"}],
    "menu": "System Forum"
  }, {
    "child": [{
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "system announcement",
      "tableName": "news"
    }, {
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "FAQ",
      "tableName": "chat"
    }, {"buttons": ["New", "view", "Modify", "Delete"], "menu": "Swiper manage", "tableName": "config"}],
    "menu": "System Management"
  }, {
    "child": [{
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "Quiz List",
      "tableName": "exampaperlist"
    }, {
      "buttons": ["New", "view", "Modify", "Delete"],
      "menu": "Quiz records",
      "tableName": "examrecord"
    }, {"buttons": ["view"], "menu": "Wrong question", "tableName": "examfailrecord"}], "menu": "Quiz administration"
  }],
  "frontMenu": [{
    "child": [{"buttons": ["view"], "menu": "Courselist", "menuJump": "list", "tableName": "zaixianxuexi"}],
    "menu": "Coursemodule"
  }],
  "hasBackLogin": "yes",
  "hasBackRegister": "no",
  "hasFrontLogin": "no",
  "hasFrontRegister": "no",
  "roleName": "Teacher",
  "tableName": "users"
}, {
  "backMenu": [{
    "child": [{"buttons": ["Delete", "view"], "menu": "Collection Management", "tableName": "storeup"}],
    "menu": "Collection Management"
  }, {
    "child": [{
      "buttons": ["view", "Delete"],
      "menu": "Quiz records",
      "tableName": "examrecord"
    }, {"buttons": ["view", "Delete"], "menu": "Wrong question", "tableName": "examfailrecord"}, {
      "buttons": ["view"],
      "menu": "Quiz List",
      "tableName": "exampaperlist"
    }], "menu": "Quiz administration"
  }],
  "frontMenu": [{
    "child": [{"buttons": ["view"], "menu": "Courselist", "menuJump": "list", "tableName": "zaixianxuexi"}],
    "menu": "Coursemodule"
  }],
  "hasBackLogin": "yes",
  "hasBackRegister": "yes",
  "hasFrontLogin": "yes",
  "hasFrontRegister": "yes",
  "roleName": "Student",
  "tableName": "yonghu"
}]


var isAuth = function (tableName, key) {
  let role = localStorage.getItem("userTable");
  let menus = menu;
  for (let i = 0; i < menus.length; i++) {
    if (menus[i].tableName == role) {
      for (let j = 0; j < menus[i].backMenu.length; j++) {
        for (let k = 0; k < menus[i].backMenu[j].child.length; k++) {
          if (tableName == menus[i].backMenu[j].child[k].tableName) {
            let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
            return buttons.indexOf(key) !== -1 || false
          }
        }
      }
    }
  }
  return false;
}

var isFrontAuth = function (tableName, key) {
  let role = localStorage.getItem("userTable");
  let menus = menu;
  for (let i = 0; i < menus.length; i++) {
    if (menus[i].tableName == role) {
      for (let j = 0; j < menus[i].frontMenu.length; j++) {
        for (let k = 0; k < menus[i].frontMenu[j].child.length; k++) {
          if (tableName == menus[i].frontMenu[j].child[k].tableName) {
            let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
            return buttons.indexOf(key) !== -1 || false
          }
        }
      }
    }
  }
  return false;
}

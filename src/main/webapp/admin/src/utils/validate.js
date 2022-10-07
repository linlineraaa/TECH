
export function isEmail (s) {
  return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
}


export function isMobile (s) {
  return /^1[0-9]{10}$/.test(s)
}


export function isPhone (s) {
  return /^([0-9]{3,4}-)?[0-9]{7,8}$/.test(s)
}


export function isURL (s) {
  return /^http[s]?:\/\/.*/.test(s)
}


export function isNumber(s){
  return  /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/.test(s);
}

export function isIntNumer(s){
  return  /(^-?\d+$)|(^$)/.test(s);
}

export function checkIdCard(idcard) {
  const regIdCard = /(^\d{9}$)/;
  return regIdCard.test(idcard);
}

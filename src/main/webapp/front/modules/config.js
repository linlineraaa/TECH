window.rootPath = (function (src) {
    src = document.scripts[document.scripts.length - 1].src;
	console.log(src.substring(0, src.lastIndexOf("/") + 1))
    return src.substring(0, src.lastIndexOf("/") + 1);
})();

layui.config({
    base: rootPath,
    version: true
}).extend({
    http: 'http/http',
	tinymce: 'tinymce/tinymce'
});
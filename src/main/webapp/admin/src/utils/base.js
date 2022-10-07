const base = {
    get() {
                return {
            url : "http://localhost:8080/teach/",
            name: "teach",
            
            indexUrl: 'http://localhost:8080/teach/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "Teach Programming Website"
        } 
    }
}
export default base

class Cookies{

    constructor(){

    }

    getAll(){
        let row = document.cookie;

        let cookies = row.split(';');

        let _cookies = [];

        cookies.forEach(cookie => {

            let keyvalue = cookie.split('=');

            _cookies.push({key:keyvalue[0], value:keyvalue[1]});
        })

        return _cookies;
    }

    exists(name){

        let _exists = false;

        this.getAll().forEach(cookie => {
            if (cookie.key == name){
                _exists = true;
                return;
            }
        });

        return _exists;
    }


}

export default Cookies;
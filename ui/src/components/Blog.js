import React from 'react';
import axios from 'axios';


class Card extends React.Component{

  constructor(props){
    super(props);
  }

  render(){

    let data = this.props.data;
    return(
      <div className="row  shadow-sm rounded mb-2" style={{backgroundColor:"white"}}>
        <div className="col-12">
          <div className="row">
            <div className="col">
              <div className="row m-0 pl-2 pr-2 pt-2">
                <h4>{data.title}</h4>
              </div>
              <div className="row pl-4 pr-4 pt-0 pb-1">
                <p style={{color:'grey'}}>{data.content}</p>
              </div>
            </div>
          </div>
          <div className="row p-2 border-top align-items-center justify-content-center">
            <div className="col" style={{fontSize: '12px', color:'grey'}}>
              <span style={{fontSize:'10px'}}>{data.date}</span>
            </div>
            <div className="ml-auto">
              {/* <span style={{fontSize:'10px',color:'#757575', fontWeight:'bold'}} className="align-middle mr-3"><i className="material-icons mr-1" style={{verticalAlign:'middle', fontSize:'14px', color:'#9e9e9e'}}>thumb_up</i>24</span> */}
              <span style={{fontSize:'10px',color:'#757575', fontWeight:'bold'}} className="align-middle mr-3"><i className="material-icons mr-1" style={{verticalAlign:'middle', fontSize:'14px', color:'#9e9e9e'}}>share</i>SHARE</span>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

class Blog extends React.Component{

  constructor(props){
    super(props)

    this.state = {cpr:3, data:[]};
  }

  calculateRows(data){

    let calc = data.length / this.state.cpr;

    let rows = parseInt(calc);

    return calc % this.state.cpr == 0 ? rows : rows+1;
  }

  componentDidMount(){
    axios.get("http://localhost:81/api/v1/blog/posts", {headers:{'Access-Control-Allow-Origin':'*'}}).then(result => {
      this.setState({data:result.data});
    })
  }

  render(){
    // let data = [
    //   {
    //     title:'Of love and other mental illneses',
    //     content:'this is the content of the article',
    //     author:'william',
    //     date:'01.04.2019, 3:07pm',
    //     likes:'24',
    //   }
    // ];
    let data = this.state.data;


    let rows = [];

    for (let i = 0,offset=0; i < this.calculateRows(data); i++){
      let _data = data.slice(offset, offset+this.state.cpr);
      offset = offset+this.state.cpr;
      rows.push(
        <div className="row justify-content-center" key={i}>
          {_data.map((row, idx) => 
            <div className="col mr-1" key={idx}>
              <Card data={row}/>
            </div>
          )}
        </div>
      )
    }


    return(
      <div>
        {rows}
      </div>
    )
  }
}

export default Blog;
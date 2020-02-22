import React from 'react';
import axios from 'axios';
import crypto from 'crypto';

import Favorites from './components/Favorites';
import Blog from './components/Blog';
import Education from './components/Education';
import Projects from './components/Projects';
import Work from './components/Work';

class Navbar extends React.Component{
  constructor(){
    super();
  }

  render(){
    return (
      <div className="row  mb-1 align-items-center">
        <div className="ml-auto p-1"> 
          
        </div>
      </div>
    );
  }
}

class Profile extends React.Component{
  constructor(props){
    super(props);
  }

  render(){
    return(
      <div className="row">
        <div className="col">
          <div className="row align-items-center justify-content-center">
            <img className="rounded-circle" src={this.props.profile.photo} style={{maxWidth:'100%',maxHeight:'100%', background:'white'}}></img>
          </div>
          <div className="row align-items-center justify-content-center">
            <span>{this.props.profile.name}</span>
          </div>
        </div>
      </div>
    )
  }
}


class App extends React.Component{

  constructor(){
    super();

    this.components = {
      "favorites":{title:'things I like', payload:Favorites},
      "blog":{title:'things I say', payload:Blog},
      "projects":{title:'things I do', payload:Projects},
      "work":{title:'Work Experience', payload:Work},
      "education":{title:'Education', payload:Education}
    };

    this.state = {component:{header:this.components['favorites'].title, payload:Favorites}};

    this.handleMenuClick = this.handleMenuClick.bind(this);


  }
  
  
  componentWillMount(){

  }

  componentDidMount(){

    let h = crypto.createHash('sha256');
    h.update("some data yo");
    console.log(h.digest('hex'));
    console.log(document.cookie);
    document.cookie = "username=testing"

    axios.get("http://localhost:81/api/v1/user/unique/cookie", {headers:{'Access-Control-Allow-Origin':'*'}}).then(result => {
      console.log(result.data);
    })
  }

  handleMenuClick(id){
    this.setState({
      component:{
        header:this.components[id].title,
        payload:this.components[id].payload
      }
    });
  }

  render(){

    let Component = this.state.component.payload;

    return (
      
      <div className="col-12">
        <Navbar />

        {/** MAIN ROW */}
        <div className="row">



          {/** MAIN CONTENT */}
          <div className="col">

            <div className="row mt-4 justify-content-center">
              <img src="../resources/img/name.png" style={{height:'68px'}}></img>
            </div>
            <div className="row mt-4 justify-content-center">
              <div className="col-md-4">
                <div className="row align-items-center justify-content-center" style={{letterSpacing:'1px', textTransform:'uppercase'}}>
                  <a href="#" className="pr-4 main-nav-link" onClick={(e) => this.handleMenuClick('blog', e)}>BLOG</a>
                  <a href="#" className="pr-4 main-nav-link" onClick={(e) => this.handleMenuClick('favorites', e)}>FAVORITES</a>
                  <a href="#" className="main-nav-link" onClick={(e) => this.handleMenuClick('projects', e)}>PROJECTS</a>
                </div>
              </div>
            </div>


            <div className="row mt-4" style={{background: '#f5f5f5'}}>
              <div className="col">

                <div className="row justify-content-center">
                  <div className="col-md-10" style={{backgroundColor:'#f5f5f5'}}>
                    <div className="row align-items-center justify-content-center p-4">
                      <h1>{this.state.component.header}</h1>
                    </div>
                  </div>
                </div>

                <div className="row justify-content-center">
                  <div className="col-md-10" style={{height:'90vh'}}>
                    <Component />
                  </div>
                </div>

              </div>
            </div>

          </div>

        </div>

        <div className="row fixed-bottom">
          <div className="col">
            <div className="row align-items-center justify-content-center">
              <i className="fab fa-facebook-square fa-2x mr-1"></i> 
              <i className="fab fa-linkedin fa-2x mr-1"></i>
              <i className="fab fa-github-square fa-2x"></i>
            </div>
          </div>
        </div>

      </div>
    );
  }
}

export default App;

import React, { useState } from 'react';
import {Tabs,Tab, makeStyles, AppBar} from '@material-ui/core';
import {useHistory} from 'react-router-dom';


const useStyles=makeStyles(theme=>({
    root:{
        minHeight:window.innerHeight  - 65//,
        //width:"250px"
    }
}));

const LeftMenu = ()=>{
    const [tabVal,setTabVal] = useState("/");
    const history = useHistory();

    const tabChange=(event,newVal)=>{
        console.log("NewVal->",newVal);        
        setTabVal(newVal);
        history.push(newVal);
    }

    const classes = useStyles();
    return (
        <AppBar color={"transparent"} position="static" className={classes.root}>
        <Tabs value={tabVal}
         indicatorColor="primary"
         textColor="primary"
         onChange={tabChange} orientation="vertical">
            <Tab value={"/"} label="Overview"></Tab>
            <Tab value={"/node"} label="Cluster Nodes"></Tab>
            <Tab value={"/topic"} label="Topics"></Tab>
            <Tab value={"/consumer"} label="Consumers"></Tab>
        </Tabs> 
        </AppBar>       
    );
}
export default LeftMenu;

import React, { useEffect, useState } from 'react';
import {useHistory} from 'react-router-dom';
import {DataGrid} from '@material-ui/data-grid';
import {Link} from '@material-ui/core';
import Constants from './../../Utils/Constants';
import { makeStyles } from '@material-ui/core';

const useStyles = makeStyles(()=>({
  root:{
      height:"100px",
      "& .MuiDataGrid-footer":{
          justifyContent:"flex-end"
      }
  },
  linkRoot:{
      cursor:"pointer"
  }  
}));

const TopicGrid = ()=>{
    console.log("Node Grid-->");
    const [topics,setTopics] = useState([]);
    const history = useHistory();

   const formatTopics=(res)=>{
        return res?.topicInfoList?.map((topic)=>{
            topic.id = topic.topicName;
            return topic;
        });
    }
    
    useEffect(()=>{
          fetch(Constants.BASE_URL+"/getTopics").then(res=>res.json())
          .then((res)=>{
              console.log("NodeInfoList",res?.topicInfoList);
              setTopics(formatTopics(res));
          });
    },[]);

    const openPartition=(params)=>{
        history.push({
            pathname:"/topic/"+params.getValue("topicName")+"/partition",
            state:params.data
        });
    }

    const classes = useStyles();

    return (
        <div style={{ minHeight: 400,height:"100%", width: '100%' }}>
        <DataGrid className={classes.root}
            columns={[
                {field:'topicName',headerName:"Topic Name",width:200},                             
                {field:"partitionCount",headerName:"Partition Count",width:150,
                    renderCell:(params)=>{
                         return (
                             <Link className={classes.linkRoot} onClick={openPartition.bind(this,params)}>{params.value}</Link>
                         )   
                    }
                },
                {field:'id',hide:true},   
            ]}
            rows={topics}
            hideFooterPagination={true}
        >
        </DataGrid>
        </div>
    );


}
export default TopicGrid;
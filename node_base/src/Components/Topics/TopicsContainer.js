
import { Grid, Typography,Fade  } from '@material-ui/core';
import React from 'react';
import TopicGrid from './TopicGrid';

const TopicsContainer = ()=>{
    

    return (
       <Fade  in={true}>
        <Grid container direction="column">  
             <Grid item xs={12}><Typography variant="h5" style={{padding:"30px"}}> Topics Details</Typography></Grid>          
             <Grid item xs={12} height={100}> <TopicGrid />   </Grid>
        </Grid>
        </Fade >            
     );
}
export default TopicsContainer;
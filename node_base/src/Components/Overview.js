import {Card, CardContent, CardHeader, Grid, makeStyles, Typography,Hidden } from '@material-ui/core';
import React from 'react';

const useStyles=makeStyles(theme=>({
    root:{
        flexGrow:1,
        minHeight:"100%",
        height:"auto"
    },
    cardHeader:{
        backgroundColor:"#aaaaff",
        height:"20px",
        fontSize:"14px"
    }
}));

const Overview = ()=>{

    const classes = useStyles();

    return (
        <Grid container direction="column"
            className={classes.root} 
                justify="center"                 
            >
            <Grid item container className={classes.row}
                    justify="center"
            >   
                <Hidden mdDown>
                  <Grid item sm={false} md={1}></Grid>
                </Hidden>
                <Grid item xs={12} sm={4} md={4} style={{padding:"20px"}}>
                    <Card>
                        <CardHeader className={classes.cardHeader} title={<Typography>No of Nodes</Typography>}></CardHeader>
                        <CardContent>
                            <Typography variant="h3" align="center">10</Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={4} md={4} style={{padding:"20px"}}>
                    <Card>
                        <CardHeader className={classes.cardHeader} title={<Typography>No of Topics</Typography>}></CardHeader>
                        <CardContent>
                            <Typography variant="h3" align="center">10</Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Hidden mdDown>
                  <Grid item sm={false} md={1}></Grid>
                </Hidden>
            </Grid>
            <Grid item container className={classes.row}
                    justify="center"
            >   
                <Hidden mdDown>
                  <Grid item sm={false} md={1}></Grid>
                </Hidden>
                <Grid item xs={12} sm={4} md={4} style={{padding:"20px"}}>
                    <Card>
                        <CardHeader className={classes.cardHeader} title={<Typography>No of Nodes</Typography>}></CardHeader>
                        <CardContent>
                            <Typography variant="h3" align="center">10</Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={4} md={4} style={{padding:"20px"}}>
                    <Card>
                        <CardHeader className={classes.cardHeader} title={<Typography>No of Topics</Typography>}></CardHeader>
                        <CardContent>
                            <Typography variant="h3" align="center">10</Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Hidden mdDown>
                  <Grid item sm={false} md={1}></Grid>
                </Hidden>
            </Grid>
        </Grid>
    );
}   
export default Overview;
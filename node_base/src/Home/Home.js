import React from 'react';

import { Grid, makeStyles, ThemeProvider,Hidden } from '@material-ui/core';
import theme from './../Theme/Theme';
import Header from './../Header/Header';
import LeftMenu from './../Components/LeftMenu';
import BaseComponents from '../Components/BaseComponent';

const useStyles=makeStyles(theme=>({
    root:{
        flexGrow:1
    },
    row:{
        flexGrow:1
    }
}));

const Home = (props) => {

    const classes = useStyles();

    return (
        <ThemeProvider theme={theme}>
        <Grid container direction="column" className={classes.root} > 
            <Grid item>
                <Header></Header>
            </Grid>
            <Grid item container>
                <Hidden xsDown only="xs"> 
                    <Grid item xs={false} sm={2}>
                        <LeftMenu />
                    </Grid>
                </Hidden>
                <Grid item className={classes.row} xs={12} sm={10}>
                    <BaseComponents />
                </Grid>
            </Grid>
        </Grid>
        </ThemeProvider>
    )
}
export default Home;
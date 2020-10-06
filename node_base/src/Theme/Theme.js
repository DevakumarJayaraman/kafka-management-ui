import {createMuiTheme} from '@material-ui/core';
const theme = createMuiTheme({
    overrides:{
        MuiButton:{
            root:{
                textTransform:"none"
            }
        },
        MuiTab:{
            root:{
                textTransform:"none"
            }
        }
    }
});
export default theme;
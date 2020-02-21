import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Sinhvien from './sinhvien';
import SinhvienDetail from './sinhvien-detail';
import SinhvienUpdate from './sinhvien-update';
import SinhvienDeleteDialog from './sinhvien-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={SinhvienDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SinhvienUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SinhvienUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SinhvienDetail} />
      <ErrorBoundaryRoute path={match.url} component={Sinhvien} />
    </Switch>
  </>
);

export default Routes;

import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './sinhvien.reducer';
import { ISinhvien } from 'app/shared/model/sinhvien.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISinhvienProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Sinhvien = (props: ISinhvienProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { sinhvienList, match, loading } = props;
  return (
    <div>
      <h2 id="sinhvien-heading">
        <Translate contentKey="dangkythitienghanApp.sinhvien.home.title">Sinhviens</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="dangkythitienghanApp.sinhvien.home.createLabel">Create new Sinhvien</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {sinhvienList && sinhvienList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.alevel">Alevel</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.imgidx">Imgidx</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uadd">Uadd</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth0">Ubirth 0</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth1">Ubirth 1</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth2">Ubirth 2</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uemail0">Uemail 0</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uemail1">Uemail 1</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uhp">Uhp</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ujob">Ujob</Translate>
                </th>
                <th>
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ukname">Ukname</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {sinhvienList.map((sinhvien, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${sinhvien.id}`} color="link" size="sm">
                      {sinhvien.id}
                    </Button>
                  </td>
                  <td>{sinhvien.alevel}</td>
                  <td>{sinhvien.imgidx}</td>
                  <td>{sinhvien.uadd}</td>
                  <td>{sinhvien.ubirth0}</td>
                  <td>{sinhvien.ubirth1}</td>
                  <td>{sinhvien.ubirth2}</td>
                  <td>{sinhvien.uemail0}</td>
                  <td>{sinhvien.uemail1}</td>
                  <td>{sinhvien.uhp}</td>
                  <td>{sinhvien.ujob}</td>
                  <td>{sinhvien.ukname}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${sinhvien.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${sinhvien.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${sinhvien.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="dangkythitienghanApp.sinhvien.home.notFound">No Sinhviens found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ sinhvien }: IRootState) => ({
  sinhvienList: sinhvien.entities,
  loading: sinhvien.loading
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Sinhvien);

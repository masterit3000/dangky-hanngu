import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './sinhvien.reducer';
import { ISinhvien } from 'app/shared/model/sinhvien.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISinhvienDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const SinhvienDetail = (props: ISinhvienDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { sinhvienEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="dangkythitienghanApp.sinhvien.detail.title">Sinhvien</Translate> [<b>{sinhvienEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="alevel">
              <Translate contentKey="dangkythitienghanApp.sinhvien.alevel">Alevel</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.alevel}</dd>
          <dt>
            <span id="imgidx">
              <Translate contentKey="dangkythitienghanApp.sinhvien.imgidx">Imgidx</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.imgidx}</dd>
          <dt>
            <span id="uadd">
              <Translate contentKey="dangkythitienghanApp.sinhvien.uadd">Uadd</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.uadd}</dd>
          <dt>
            <span id="ubirth0">
              <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth0">Ubirth 0</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.ubirth0}</dd>
          <dt>
            <span id="ubirth1">
              <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth1">Ubirth 1</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.ubirth1}</dd>
          <dt>
            <span id="ubirth2">
              <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth2">Ubirth 2</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.ubirth2}</dd>
          <dt>
            <span id="uemail0">
              <Translate contentKey="dangkythitienghanApp.sinhvien.uemail0">Uemail 0</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.uemail0}</dd>
          <dt>
            <span id="uemail1">
              <Translate contentKey="dangkythitienghanApp.sinhvien.uemail1">Uemail 1</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.uemail1}</dd>
          <dt>
            <span id="uhp">
              <Translate contentKey="dangkythitienghanApp.sinhvien.uhp">Uhp</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.uhp}</dd>
          <dt>
            <span id="ujob">
              <Translate contentKey="dangkythitienghanApp.sinhvien.ujob">Ujob</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.ujob}</dd>
          <dt>
            <span id="ukname">
              <Translate contentKey="dangkythitienghanApp.sinhvien.ukname">Ukname</Translate>
            </span>
          </dt>
          <dd>{sinhvienEntity.ukname}</dd>
        </dl>
        <Button tag={Link} to="/sinhvien" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/sinhvien/${sinhvienEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ sinhvien }: IRootState) => ({
  sinhvienEntity: sinhvien.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SinhvienDetail);

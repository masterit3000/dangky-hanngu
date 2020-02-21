import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './sinhvien.reducer';
import { ISinhvien } from 'app/shared/model/sinhvien.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ISinhvienUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const SinhvienUpdate = (props: ISinhvienUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { sinhvienEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/sinhvien');
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...sinhvienEntity,
        ...values
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="dangkythitienghanApp.sinhvien.home.createOrEditLabel">
            <Translate contentKey="dangkythitienghanApp.sinhvien.home.createOrEditLabel">Create or edit a Sinhvien</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : sinhvienEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="sinhvien-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="sinhvien-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="alevelLabel" for="sinhvien-alevel">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.alevel">Alevel</Translate>
                </Label>
                <AvField
                  id="sinhvien-alevel"
                  type="string"
                  className="form-control"
                  name="alevel"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') },
                    min: { value: 7, errorMessage: translate('entity.validation.min', { min: 7 }) },
                    max: { value: 8, errorMessage: translate('entity.validation.max', { max: 8 }) },
                    number: { value: true, errorMessage: translate('entity.validation.number') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="imgidxLabel" for="sinhvien-imgidx">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.imgidx">Imgidx</Translate>
                </Label>
                <AvField id="sinhvien-imgidx" type="string" className="form-control" name="imgidx" />
              </AvGroup>
              <AvGroup>
                <Label id="uaddLabel" for="sinhvien-uadd">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uadd">Uadd</Translate>
                </Label>
                <AvField
                  id="sinhvien-uadd"
                  type="text"
                  name="uadd"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="ubirth0Label" for="sinhvien-ubirth0">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth0">Ubirth 0</Translate>
                </Label>
                <AvField
                  id="sinhvien-ubirth0"
                  type="string"
                  className="form-control"
                  name="ubirth0"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') },
                    min: { value: 1900, errorMessage: translate('entity.validation.min', { min: 1900 }) },
                    max: { value: 2020, errorMessage: translate('entity.validation.max', { max: 2020 }) },
                    number: { value: true, errorMessage: translate('entity.validation.number') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="ubirth1Label" for="sinhvien-ubirth1">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth1">Ubirth 1</Translate>
                </Label>
                <AvField
                  id="sinhvien-ubirth1"
                  type="string"
                  className="form-control"
                  name="ubirth1"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') },
                    min: { value: 1, errorMessage: translate('entity.validation.min', { min: 1 }) },
                    max: { value: 12, errorMessage: translate('entity.validation.max', { max: 12 }) },
                    number: { value: true, errorMessage: translate('entity.validation.number') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="ubirth2Label" for="sinhvien-ubirth2">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ubirth2">Ubirth 2</Translate>
                </Label>
                <AvField
                  id="sinhvien-ubirth2"
                  type="string"
                  className="form-control"
                  name="ubirth2"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') },
                    min: { value: 1, errorMessage: translate('entity.validation.min', { min: 1 }) },
                    max: { value: 31, errorMessage: translate('entity.validation.max', { max: 31 }) },
                    number: { value: true, errorMessage: translate('entity.validation.number') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="uemail0Label" for="sinhvien-uemail0">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uemail0">Uemail 0</Translate>
                </Label>
                <AvField
                  id="sinhvien-uemail0"
                  type="text"
                  name="uemail0"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="uemail1Label" for="sinhvien-uemail1">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uemail1">Uemail 1</Translate>
                </Label>
                <AvField
                  id="sinhvien-uemail1"
                  type="text"
                  name="uemail1"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="uhpLabel" for="sinhvien-uhp">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.uhp">Uhp</Translate>
                </Label>
                <AvField
                  id="sinhvien-uhp"
                  type="text"
                  name="uhp"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="ujobLabel" for="sinhvien-ujob">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ujob">Ujob</Translate>
                </Label>
                <AvField
                  id="sinhvien-ujob"
                  type="text"
                  name="ujob"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="uknameLabel" for="sinhvien-ukname">
                  <Translate contentKey="dangkythitienghanApp.sinhvien.ukname">Ukname</Translate>
                </Label>
                <AvField
                  id="sinhvien-ukname"
                  type="text"
                  name="ukname"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/sinhvien" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  sinhvienEntity: storeState.sinhvien.entity,
  loading: storeState.sinhvien.loading,
  updating: storeState.sinhvien.updating,
  updateSuccess: storeState.sinhvien.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SinhvienUpdate);

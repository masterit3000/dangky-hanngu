import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISinhvien, defaultValue } from 'app/shared/model/sinhvien.model';

export const ACTION_TYPES = {
  FETCH_SINHVIEN_LIST: 'sinhvien/FETCH_SINHVIEN_LIST',
  FETCH_SINHVIEN: 'sinhvien/FETCH_SINHVIEN',
  CREATE_SINHVIEN: 'sinhvien/CREATE_SINHVIEN',
  UPDATE_SINHVIEN: 'sinhvien/UPDATE_SINHVIEN',
  DELETE_SINHVIEN: 'sinhvien/DELETE_SINHVIEN',
  RESET: 'sinhvien/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISinhvien>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type SinhvienState = Readonly<typeof initialState>;

// Reducer

export default (state: SinhvienState = initialState, action): SinhvienState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SINHVIEN_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SINHVIEN):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SINHVIEN):
    case REQUEST(ACTION_TYPES.UPDATE_SINHVIEN):
    case REQUEST(ACTION_TYPES.DELETE_SINHVIEN):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SINHVIEN_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SINHVIEN):
    case FAILURE(ACTION_TYPES.CREATE_SINHVIEN):
    case FAILURE(ACTION_TYPES.UPDATE_SINHVIEN):
    case FAILURE(ACTION_TYPES.DELETE_SINHVIEN):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SINHVIEN_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_SINHVIEN):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SINHVIEN):
    case SUCCESS(ACTION_TYPES.UPDATE_SINHVIEN):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SINHVIEN):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/sinhviens';

// Actions

export const getEntities: ICrudGetAllAction<ISinhvien> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_SINHVIEN_LIST,
  payload: axios.get<ISinhvien>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ISinhvien> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SINHVIEN,
    payload: axios.get<ISinhvien>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISinhvien> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SINHVIEN,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISinhvien> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SINHVIEN,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISinhvien> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SINHVIEN,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

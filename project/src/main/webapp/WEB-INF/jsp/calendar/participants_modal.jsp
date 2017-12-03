<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- MODAL -->
<div id="addParticipantModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">PARTICIPANTES</h4>
            </div>
            <div class="modal-body participant-list">
                <ul>
                    <c:forEach items="${ participants }" var="user">
	                    <li>${ user.email }
	                        <button class="delete-participant-button">x</button>
	                        <label class="switch">
	                            <input type="checkbox" checked>
	                            <span class="slider round"></span>
	                        </label>
	                        Read Only
	                    </li>
                    </c:forEach>
                </ul>
                <div class="add-participant-div col-md-12">
                    <input class="col-md-8 col-xs-8 col-sm-8" placeholder="E-mail de usuário" type="text" />
                    <button class="col-md-4 col-xs-4 col-sm-4 pull-right">ADD</button>
                </div>
            </div>
            <button type="button" class="modal-button" data-dismiss="modal">FECHAR</button>
        </div>
    </div>
</div>
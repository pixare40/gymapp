package com.zola.gym



import grails.test.mixin.*
import spock.lang.*

@TestFor(PayBundleController)
@Mock(PayBundle)
class PayBundleControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.payBundleInstanceList
            model.payBundleInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.payBundleInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def payBundle = new PayBundle()
            payBundle.validate()
            controller.save(payBundle)

        then:"The create view is rendered again with the correct model"
            model.payBundleInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            payBundle = new PayBundle(params)

            controller.save(payBundle)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/payBundle/show/1'
            controller.flash.message != null
            PayBundle.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def payBundle = new PayBundle(params)
            controller.show(payBundle)

        then:"A model is populated containing the domain instance"
            model.payBundleInstance == payBundle
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def payBundle = new PayBundle(params)
            controller.edit(payBundle)

        then:"A model is populated containing the domain instance"
            model.payBundleInstance == payBundle
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/payBundle/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def payBundle = new PayBundle()
            payBundle.validate()
            controller.update(payBundle)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.payBundleInstance == payBundle

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            payBundle = new PayBundle(params).save(flush: true)
            controller.update(payBundle)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/payBundle/show/$payBundle.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/payBundle/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def payBundle = new PayBundle(params).save(flush: true)

        then:"It exists"
            PayBundle.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(payBundle)

        then:"The instance is deleted"
            PayBundle.count() == 0
            response.redirectedUrl == '/payBundle/index'
            flash.message != null
    }
}

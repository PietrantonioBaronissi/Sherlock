$(document).ready(function()
{
    //espressioni regolari di controllo
    const titoloRegex = /^[a-z\xE0\xE8\xE9\xF9\xF2\xEC\x270-9\s]{1,255}$/i;
    const descrizioneRegex = /^[a-z\xE0\xE8\xE9\xF9\xF2\xEC\x270-9\s]{1,255}$/i;
    const informazioniRegex = /^[a-z\xE0\xE8\xE9\xF9\xF2\xEC\x270-9\s]{1,10000}$/i;
    const dettagliRegex = /^[a-z\xE0\xE8\xE9\xF9\xF2\xEC\x270-9\s]{1,10000}$/i;
    const luoghiRegex = /^[a-z\xE0\xE8\xE9\xF9\xF2\xEC\x270-9\s]{1,255}$/i;
    const tramaRegex = /^[a-z\xE0\xE8\xE9\xF9\xF2\xEC\x270-9\s]{1,10000}$/i;

    //evento submit del form
    $('#clientForm').submit((event) =>
    {
        event.preventDefault();
        const titolo = $('#aTitolo').val();
        alert(titolo);
        const descrizione = $('#aDescrizioni').val();
        const informazioni = $('#aInformazioni').val();
        const dettagli = $('#aDettagli').val();
        const luoghi = $('#aLuoghi').val();
        const trama = $('#aTrama').val();

        const formResult = checkData(titolo,descrizione,informazioni,dettagli,luoghi,trama);
        /*if(formResult[0] && formResult[1] && formResult[2] && formResult[3] && formResult[4] && formResult[5])
            sendData(titolo,descrizione,informazioni,dettagli,luoghi,trama);
        else
            showErrors(formResult);*/
    });

    //controllo validità campi
    const checkData = (titolo,descrizione,informazioni,dettagli,luoghi,trama) =>
    {
        return new Array
        (
            titoloRegex.test(titolo),
            descrizioneRegex.test(descrizione),
            informazioniRegex.test(informazioni),
            dettagliRegex.test(dettagli),
            luoghiRegex.test(luoghi),
            tramaRegex.test(trama)
        );
    }

    //gestione messaggi di errore
    const showErrors = (formResult) =>
    {
        if(!formResult[0])
        {
            $('#descrError').css({'display':'block'});
            return;
        }
        if(!formResult[1])
        {
            $('#descrError').css({'display':'block'});
            return;
        }
        if(!formResult[2])
        {
            $('#descrError').css({'display':'block'});
            return;
        }
        if(!formResult[3])
        {
            $('#descrError').css({'display':'block'});
            return;
        }
        if(!formResult[4])
        {
            $('#descrError').css({'display':'block'});
            return;
        }
        if(!formResult[5])
        {
            $('#descrError').css({'display':'block'});
            return;
        }
    }

	//invio dati 
    const sendData = (titolo,descrizione,informazioni,dettagli,luoghi,trama) =>
    {
        $.post
	    (
	      'article/saveclient',
	      {
			titolo:titolo,
	        descrizione:descrizione,
	        informazioni:informazioni,
	        dettagli:dettagli,
	        luoghi:luoghi,
	        trama:trama,
	      },
	      function (response)
	      {
	        if (response === 'save success')
				location.href = '/esercizio-3';
	      }
	    );
    }

    //reset dei messaggi di errore
	$('#aTitolo').focusin(function ()
	{
	  $('#descrError').css({'display':'none'});
	});
	$('#aDescrizione').focusin(function ()
	{
	  $('#descrError').css({'display':'none'});
	});
	$('#aInformazioni').focusin(function ()
	{
	  $('#descrError').css({'display':'none'});
	});
	$('#aDettagli').focusin(function ()
	{
	  $('#descrError').css({'display':'none'});
	});
	$('#aLuoghi').focusin(function ()
	{
	  $('#descrError').css({'display':'none'});
	});
	$('#aTrama').focusin(function ()
	{
	  $('#descrError').css({'display':'none'});
	});
	
});